package tr.gov.tubitak.bilgem.yte.yte_demo_app.entegrasyon.synccall.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import tr.gov.tubitak.bilgem.yte.infra.ytemessagecontext.message.messagecontext.MessageContextHolder;
import tr.gov.tubitak.bilgem.yte.infra.ytemessagecontext.message.pojo.Message;
import tr.gov.tubitak.bilgem.yte.infra.yterest.exception.RestCallResponseException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestService {

    private final WebClient oAuth2SupportedWebClient;
    private final MessageContextHolder messageContextHolder;

    @Value("${client.test.url:#{null}}")
    private String url;

    public String getTestData(String request) {
        String response = null;
        try {
            response = oAuth2SupportedWebClient
                    .post()
                    .uri(url)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (RestCallResponseException ex) {
            // To be able to catch this exception here, an error message needs to be added to messageContextHolder on the server side.
            log.error(TestServiceMessages.ERROR_TEST_SERVICE_RETURNED_ERROR, ex);
            Message error = ex.getFirstError();
            messageContextHolder.addErrorMessage(TestServiceMessages.ERROR_TEST_SERVICE_RETURNED_ERROR, error.getMessage());
        } catch (Exception ex) {
            log.error(TestServiceMessages.ERROR_TEST_DATA_COULD_NOT_BE_RETRIEVED, ex);
            messageContextHolder.addErrorMessage(TestServiceMessages.ERROR_TEST_DATA_COULD_NOT_BE_RETRIEVED);
        }
        return response;
    }

}
