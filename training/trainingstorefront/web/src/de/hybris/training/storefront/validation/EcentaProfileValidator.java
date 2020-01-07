package de.hybris.training.storefront.validation;

import de.hybris.training.facades.forms.UpdateProfileForm;
import org.apache.commons.lang.StringUtils;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component("ecentaProfileValidator")
public class EcentaProfileValidator implements Validator
{

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return UpdateProfileForm.class.equals(aClass);
    }

    @Override
    public void validate(final Object object, final Errors errors)
    {
        final UpdateProfileForm profileForm = (UpdateProfileForm) object;
        final String title = profileForm.getTitleCode();
        final String firstName = profileForm.getFirstName();
        final String lastName = profileForm.getLastName();
        final String phoneNumber = profileForm.getPhoneNumber();

        if (StringUtils.isNotEmpty(title) && StringUtils.length(title) > 255)
        {
            errors.rejectValue("titleCode", "profile.title.invalid");
        }

        if (StringUtils.isBlank(firstName))
        {
            errors.rejectValue("firstName", "profile.firstName.invalid");
        }
        else if (StringUtils.length(firstName) > 255)
        {
            errors.rejectValue("firstName", "profile.firstName.invalid");
        }

        if (StringUtils.isBlank(lastName))
        {
            errors.rejectValue("lastName", "profile.lastName.invalid");
        }
        else if (StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "profile.lastName.invalid");
        }

        if (StringUtils.isBlank(phoneNumber))
        {
            errors.rejectValue("phoneNumber", "profile.phoneNumber.invalid");
        }
        else if (StringUtils.length(phoneNumber) > 255)
        {
            errors.rejectValue("phoneNumber", "profile.phoneNumber.invalid");
        }
    }

}