package wrappers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;

public class GenericWrappers extends IosWebWrappers {
    public void startAppiumServer() {
        builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
//      TODO: update with correct path of your machine
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
        builder.withAppiumJS(new File("C:\\Users\\lokthy\\AppData\\Roaming\\npm\\node_modules\\appium"));
//      TODO: uncomment the below lines for MAC nachine
//      HashMap<String, String> environment = new HashMap();
//      environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
//      builder.withEnvironment(environment);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        serverURL = String.valueOf(service.getUrl());
    }

    public void stopAppiumServer() {
        service.stop();
    }
}
