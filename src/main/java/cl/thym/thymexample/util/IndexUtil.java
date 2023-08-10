package cl.thym.thymexample.util;

import cl.thym.thymexample.enums.IndexEnums;
import cl.thym.thymexample.enums.Thymenum;
import cl.thym.thymexample.enums.entity.UserEnum;
import org.springframework.ui.Model;

public class IndexUtil {

    /**
     * Autofills model object with common titles and parameters on index screen.
     * @param model
     * @return Model object with parameters for index screen.
     */
    public static Model fillIndexModel(Model model) {

        model.addAttribute("title", Thymenum.TITLE.getValue());
        model.addAttribute("userTitle", IndexEnums.USER_TITLE.getValue());
        model.addAttribute("searchUserTitle", IndexEnums.SEARCH_TITLE.getValue());
        model.addAttribute("loginTitle", IndexEnums.LOGIN_FIELD.getValue());

        model.addAttribute("userIdTitle",UserEnum.ID.getValue());
        model.addAttribute("userUsernameTitle",UserEnum.USERNAME.getValue());
        model.addAttribute("userRoleTitle",UserEnum.ROLE_ID.getValue());

        return model;
    }

}
