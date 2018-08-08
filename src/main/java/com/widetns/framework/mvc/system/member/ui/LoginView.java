package com.widetns.framework.mvc.system.member.ui;


import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.widetns.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Route("")
@PageTitle("test")
@HtmlImport("src/srclogin-view.html")
public class LoginView extends PolymerTemplate<LoginView.Model> implements PageConfigurator, AfterNavigationObserver {

    @Autowired
    private TestService service;

    @Override
    public void configurePage(InitialPageSettings settings) {
        // Force login page to use Shady DOM to avoid problems with browsers and
        // password managers not supporting shadow DOM
        settings.addInlineWithContents(InitialPageSettings.Position.PREPEND,
                "window.customElements=window.customElements||{};" +
                        "window.customElements.forcePolyfill=true;" +
                        "window.ShadyDOM={force:true};", InitialPageSettings.WrapMode.JAVASCRIPT);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        boolean error = event.getLocation().getQueryParameters().getParameters().containsKey("error");
        getModel().setError(error);
    }

    public interface Model extends TemplateModel {
        void setError(boolean error);
    }

//    public LoginView() {
//
//        setSpacing(true);
//        setSizeFull();
//        setAlignItems(Alignment.CENTER);
//
//        FormLayout formLayout = new FormLayout();
//
////        formLayout.setAlignItems(Alignment.CENTER);
//
//        H2 title = new H2("PMS");
//
//        TextField emailTextField = new TextField();
//        emailTextField.setPlaceholder("Email");
//        emailTextField.setAutofocus(true);
//        emailTextField.setRequired(true);
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPlaceholder("Password");
//        passwordField.setRequired(true);
//
//        Button btnSignIn = new Button("Sign In");
//        btnSignIn.addClickListener(buttonClickEvent -> {
//            service.testService1();
//        });
//        Button bntFindPassword = new Button("Find Password");
//        HorizontalLayout bntHorizontalLayout = new HorizontalLayout(btnSignIn, bntFindPassword);
//
////        formLayout.add(title);
////        formLayout.addFormItem(emailTextField, "Email");
////        formLayout.addFormItem(passwordField, "Password");
//        formLayout.add(emailTextField);
//        formLayout.add(passwordField);
//        formLayout.add(bntHorizontalLayout);
//
//        add(formLayout);
//        setAlignItems(Alignment.CENTER);
//    }

}
