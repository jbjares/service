package de.difuture.ekut.pht.trainupdater.controller;


import java.net.URI;

import de.difuture.ekut.pht.lib.core.dockerevent.DockerRegistryEvent;
import de.difuture.ekut.pht.lib.core.dockerevent.DockerRegistryEventIterable;
import de.difuture.ekut.pht.lib.core.messages.TrainUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Source.class)
public class TrainUpdaterController {

	private static final ResponseEntity<?> OK = ResponseEntity.ok().build();

	// Where the TrainUpdate messages are going to be sent to
	private final Source source;

	@Autowired
	public TrainUpdaterController(Source source) {

	    this.source = source;
    }

	private boolean sendTrainAvailable(
			final Long trainID,
			final URI trainRegistryURI,
			final String tag) {

		return this.source.output().send(
				MessageBuilder
						.withPayload(new TrainUpdate(trainID, trainRegistryURI, tag))
						.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
						.build()
		);
	}


	@RequestMapping(value = "/listener", method = RequestMethod.POST)	
	public ResponseEntity<?> listener(@RequestBody DockerRegistryEventIterable events) {

		for (final DockerRegistryEvent event: events) {

			final DockerRegistryEvent.Target target = event.getTarget();
			final String tag = target.getTag();

			try {
                // Sends a train available message if
                // * Docker Registry Event Action is Push
                // * The trainTag is not null
                if (event.getAction() == DockerRegistryEvent.Action.PUSH && tag != null) {

                    this.sendTrainAvailable(
                            Long.valueOf(target.getRepository()),
                            event.getRequest().getHost(),
							tag);
                }

			} catch(final IllegalArgumentException e) {

				e.printStackTrace();
			    // TODO Currently ignore DockerRegistry events that do not belong to trains
                // TODO There should be some logging going on
			}
		}
		return OK;
	}
}
