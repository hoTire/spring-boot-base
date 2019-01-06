package com.googlecode.hotire.base.controller;


import static org.assertj.core.api.Assertions.assertThat;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * http://htmlunit.sourceforge.net/gettingStarted.html
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseControllerTestHtml {

  private WebClient webClient;

  @Before
  public void config() {
    webClient = new WebClient();
  }

  @Test
  public void login() throws IOException {
    HtmlPage page = webClient.getPage(new URL("http://localhost:8080/login"));
    HtmlHeading1 h1 = page.getFirstByXPath("//h1");
    assertThat(h1.getTextContent()).isEqualToIgnoringCase("login");
  }

  @Test
  public void submittingForm() throws Exception {
    HtmlPage page = webClient.getPage(new URL("http://localhost:8080/login"));
    final HtmlForm form = page.getFirstByXPath("//form");
    final HtmlTextInput username = form.getInputByName("username");
    username.setText("admin");
    final HtmlPasswordInput password = form.getInputByName("password");
    password.setText("1234");
    final HtmlSubmitInput button = form.getInputByName("submit");
    final HtmlPage hello = button.click();
    HtmlHeading1 h1 = hello.getFirstByXPath("//h1");
    assertThat(h1.getTextContent()).isEqualToIgnoringCase("Hello admin !");
  }
}
