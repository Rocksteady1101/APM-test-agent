package cz.tipsport.elastic.apm.simpleservice.client.tasks;

import co.elastic.apm.api.CaptureTransaction;
import cz.tipsport.elastic.apm.simpleservice.client.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ClientUserTask {
    private final static Logger logger = LoggerFactory.getLogger(ClientUserTask.class);

    private RestService restService;

    @Autowired
    public ClientUserTask(RestService restService) {
        this.restService = restService;
    }

    @Scheduled(fixedDelayString = "5000")
    public void execute() {
        logger.info("run scheduled test");
        doExecute();
    }

    @CaptureTransaction(type = "ClientTask", value = "GetUsers")
    private void doExecute() {
        logger.info(restService.getUserPlainJSON());
    }

}
