package com.kozitski.xml.command;

import com.kozitski.xml.controller.Router;
import com.kozitski.xml.entity.LimitTariff;
import com.kozitski.xml.entity.UnlimitTariff;
import com.kozitski.xml.exception.XMLParseException;
import com.kozitski.xml.logic.ChooseParserReceiver;
import com.kozitski.xml.logic.ShowXmlReceiver;
import com.kozitski.xml.util.uploading.FileNameGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.List;

import static com.kozitski.xml.command.PathConstant.LOAD_FILE_JSP;
import static com.kozitski.xml.command.PathConstant.SHOW_TARIFF_JSP;

public class ShowXmlCommand implements Command{
    private static final Logger LOGGER = LogManager.getLogger(Command.class);
    private static final String PARAM_PARSER = "parser";
    private ShowXmlReceiver receiver;

    public ShowXmlCommand(ShowXmlReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Router execute(HttpServletRequest request){
        Router router = new Router();
        String page = LOAD_FILE_JSP;

        String parserType = (String) request.getSession().getAttribute(PARAM_PARSER);

        if(parserType != null && !parserType.isEmpty()){

            String loadXmlPath = request.getServletContext().getRealPath("") + "data" + File.separator + FileNameGenerator.getLastName();
            try {
                receiver.init(parserType, loadXmlPath);
            }
            catch (XMLParseException e) {
                LOGGER.error("Can not read xml file", e);
                return router;
            }

            List<LimitTariff> limitTariffs = receiver.getLimitTariffs();
            List<UnlimitTariff> unlimitTariffs = receiver.getUnlimitTariffs();

            request.setAttribute("limitList", limitTariffs);
            request.setAttribute("unlimitList", unlimitTariffs);

            page = SHOW_TARIFF_JSP;
        }

        router.setPagePath(page);
        return router;
    }

}


