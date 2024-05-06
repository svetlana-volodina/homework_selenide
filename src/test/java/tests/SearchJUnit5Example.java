package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchJUnit5Example {

	@BeforeAll
	static void beforeAll() {
		Configuration.browserSize = "1920x1080";
		Configuration.baseUrl = "https://github.com/";
		Configuration.pageLoadStrategy = "eager";
	}
	@AfterAll
	static void afterAll() {
		closeWebDriver();
	}

	@Test
	void GithubSearchJUnit5Example() {
		open("/selenide/selenide");
		$("#wiki-tab").click();

		$$("#wiki-body ul li").shouldHave(itemWithText("Soft assertions"));
		$$("#wiki-body ul li a").findBy(text("Soft Assertions")).click();

		$("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));

	}
}

