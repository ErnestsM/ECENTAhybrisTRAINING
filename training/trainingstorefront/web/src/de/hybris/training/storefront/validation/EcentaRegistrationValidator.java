package de.hybris.training.storefront.validation;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.training.facades.forms.EcentaRegisterForm;
import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validates registration forms.
 */
@Component("ecentaRegistrationValidator")
public class EcentaRegistrationValidator implements Validator
{
    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return EcentaRegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(final Object object, final Errors errors)
    {
        final EcentaRegisterForm ecentaRegisterForm = (EcentaRegisterForm) object;
        final String titleCode = ecentaRegisterForm.getTitleCode();
        final String firstName = ecentaRegisterForm.getFirstName();
        final String lastName = ecentaRegisterForm.getLastName();
        final String email = ecentaRegisterForm.getEmail();
        final String pwd = ecentaRegisterForm.getPwd();
        final String checkPwd = ecentaRegisterForm.getCheckPwd();
        final boolean termsCheck = ecentaRegisterForm.isTermsCheck();
        final String phoneNumber = ecentaRegisterForm.getPhoneNumber();

        validateTitleCode(errors, titleCode);
        validateName(errors, firstName, "firstName", "register.firstName.invalid");
        validateName(errors, lastName, "lastName", "register.lastName.invalid");

        if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "register.name.invalid");
            errors.rejectValue("firstName", "register.name.invalid");
        }

        validateEmail(errors, email);
        validatePassword(errors, pwd);
        comparePasswords(errors, pwd, checkPwd);
        validateTermsAndConditions(errors, termsCheck);

        validatePhoneNumber(errors, phoneNumber);
    }

    private void validatePhoneNumber(Errors errors, String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber))
        {
            errors.rejectValue("phoneNumber", "register.phoneNumber.invalid");
        }
        else if (StringUtils.length(phoneNumber) > 255 || !validateEmailAddress(phoneNumber))
        {
            errors.rejectValue("phoneNumber", "register.phoneNumber.invalid");
        }

    }

    protected void comparePasswords(final Errors errors, final String pwd, final String checkPwd)
    {
        if (StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(checkPwd) && !StringUtils.equals(pwd, checkPwd))
        {
            errors.rejectValue("checkPwd", "validation.checkPwd.equals");
        }
        else
        {
            if (StringUtils.isEmpty(checkPwd))
            {
                errors.rejectValue("checkPwd", "register.checkPwd.invalid");
            }
        }
    }

    protected void validatePassword(final Errors errors, final String pwd)
    {
        if (StringUtils.isEmpty(pwd))
        {
            errors.rejectValue("pwd", "register.pwd.invalid");
        }
        else if (StringUtils.length(pwd) < 6 || StringUtils.length(pwd) > 255)
        {
            errors.rejectValue("pwd", "register.pwd.invalid");
        }
    }

    protected void validateEmail(final Errors errors, final String email)
    {
        if (StringUtils.isEmpty(email))
        {
            errors.rejectValue("email", "register.email.invalid");
        }
        else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
        {
            errors.rejectValue("email", "register.email.invalid");
        }
    }

    protected void validateName(final Errors errors, final String name, final String propertyName, final String property)
    {
        if (StringUtils.isBlank(name))
        {
            errors.rejectValue(propertyName, property);
        }
        else if (StringUtils.length(name) > 255)
        {
            errors.rejectValue(propertyName, property);
        }
    }

    protected void validateTitleCode(final Errors errors, final String titleCode)
    {
        if (StringUtils.isNotEmpty(titleCode) && StringUtils.length(titleCode) > 255)
        {
            errors.rejectValue("titleCode", "register.title.invalid");
        }
    }

    protected boolean validateEmailAddress(final String email)
    {
        final Matcher matcher = Pattern.compile(configurationService.getConfiguration().getString(WebConstants.EMAIL_REGEX))
                .matcher(email);
        return matcher.matches();
    }

    protected void validateTermsAndConditions(final Errors errors, final boolean termsCheck)
    {
        if (!termsCheck)
        {
            errors.rejectValue("termsCheck", "register.terms.not.accepted");
        }
    }
}