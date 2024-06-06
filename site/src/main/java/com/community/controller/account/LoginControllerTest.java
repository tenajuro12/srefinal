import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.broadleafcommerce.profile.web.core.service.register.RegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class LoginControllerTest {

    private LoginController loginController;
    private RegistrationService registrationService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Model model;

    @Before
    public void setUp() {
        loginController = new LoginController();
        registrationService = mock(RegistrationService.class);
        loginController.setRegistrationService(registrationService);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        model = mock(Model.class);
    }

    @Test
    public void testLogin() {
        String expectedView = "loginView";
        RegisterCustomerForm registrationForm = new RegisterCustomerForm();
        when(registrationService.initCustomerRegistrationForm()).thenReturn(registrationForm);

        String actualView = loginController.login(request, response, model);

        verify(model).addAttribute("registrationForm", registrationForm);
    }
}
