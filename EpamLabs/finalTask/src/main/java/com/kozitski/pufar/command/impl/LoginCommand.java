package com.kozitski.pufar.command.impl;

import com.kozitski.pufar.command.AbstractCommand;
import com.kozitski.pufar.command.PagePath;
import com.kozitski.pufar.command.RequestValue;
import com.kozitski.pufar.command.Router;
import com.kozitski.pufar.entity.user.User;
import com.kozitski.pufar.service.autorization.LoginService;
import com.kozitski.pufar.service.autorization.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class LoginCommand extends AbstractCommand {
    private static Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String CURRENT_USER = "currentUser";

    private LoginService loginService = new LoginServiceImpl();

    @Override
    public Router execute(RequestValue request){

        Router router = new Router();
        router.setPagePath(PagePath.TEMPLATE_PAGE.getJspPath());

        String login = request.getAttribute(LOGIN).toString();
        String password = request.getAttribute(PASSWORD).toString();

        try{
            Optional<User> user = loginService.searchUserByLoginPassword(login, password);

            if(user.isPresent()){
                request.servletSessionPut(CURRENT_USER, user.get());
                router.setPagePath(PagePath.TEMPLATE_PAGE.getJspPath());
            }
            else {
                LOGGER.warn("User is not authorized");
                router.setPagePath(PagePath.LOGIN_PAGE.getJspPath());
            }
        }
        catch (Exception ex){
            router.setPagePath(PagePath.LOGIN_PAGE.getJspPath());
        }


        return router;
    }

}
