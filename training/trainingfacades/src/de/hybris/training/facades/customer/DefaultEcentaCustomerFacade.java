package de.hybris.training.facades.customer;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.core.customer.impl.EcentaCustomerAccountService;
import org.springframework.util.Assert;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

public class DefaultEcentaCustomerFacade extends DefaultCustomerFacade implements CustomerFacade {

    private EcentaCustomerAccountService ecentaCustomerAccountService;

    public EcentaCustomerAccountService getEcentaCustomerAccountService() {

        return ecentaCustomerAccountService;
    }

    public void setEcentaCustomerAccountService(EcentaCustomerAccountService ecentaCustomerAccountService) {

        this.ecentaCustomerAccountService = ecentaCustomerAccountService;

    }

    @Override
    public void updateProfile(final CustomerData customerData) throws DuplicateUidException
    {
        validateDataBeforeUpdate(customerData);

        final String name = getCustomerNameStrategy().getName(customerData.getFirstName(), customerData.getLastName());

        final CustomerModel customer = getCurrentSessionCustomer();

        final String phoneNumber = customerData.getPhoneNumber();

        customer.setOriginalUid(customerData.getDisplayUid());

        getEcentaCustomerAccountService().updateProfile(customer, customerData.getTitleCode(), name, customerData.getUid(), phoneNumber);



    }

    @Override
    public void register(final RegisterData registerData) throws DuplicateUidException
    {
        validateParameterNotNullStandardMessage("registerData", registerData);
        Assert.hasText(registerData.getFirstName(), "The field [FirstName] cannot be empty");
        Assert.hasText(registerData.getLastName(), "The field [LastName] cannot be empty");
        Assert.hasText(registerData.getLogin(), "The field [Login] cannot be empty");
        Assert.hasText(registerData.getPhoneNumber(), "The field [phoneNumber] cannot be empty");

        final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
        setCommonPropertiesForRegister(registerData, newCustomer);
        // getCustomerAccountService().register(newCustomer, registerData.getPassword());
        getEcentaCustomerAccountService().register(newCustomer, registerData.getPassword());
    }

}
