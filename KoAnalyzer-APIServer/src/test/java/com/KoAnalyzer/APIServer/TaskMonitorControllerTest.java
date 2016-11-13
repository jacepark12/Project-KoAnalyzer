package com.KoAnalyzer.APIServer;

import org.junit.Test;

/**
 * Created by parkjaesung on 2016. 11. 12..
 */
public class TaskMonitorControllerTest {
    @Test
    public void tokensToJSONString() throws Exception {
        TaskMonitorController taskMonitorController = new TaskMonitorController();

        taskMonitorController.getPhraseTextJSON();
    }

}