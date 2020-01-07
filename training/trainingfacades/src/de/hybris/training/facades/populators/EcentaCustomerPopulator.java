package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerPopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;

public class EcentaCustomerPopulator extends CustomerPopulator {

                        @Override
                        public void populate(final CustomerModel source, final CustomerData target) {
                                super.populate(source, target);
                                target.setLastLogin(source.getLastLogin().toString());
                                target.setPhoneNumber(source.getPhoneNumber());

        }

}
