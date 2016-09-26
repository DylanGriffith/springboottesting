package net.dylangriffith.acceptance;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmbeddedServerChromeAcceptanceTest extends FluentTest {

    @LocalServerPort
    int port;

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        return new ChromeDriver();
    }

    @Test
    public void testIndexPage() {
        goTo("http://localhost:" + port + "/index.html");
        assertThat(find("h1")).hasText("Spring Boot Testing Project");
    }
}
