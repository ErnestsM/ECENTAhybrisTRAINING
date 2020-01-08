/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.storefront.controllers.cms;


import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateEmailForm;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.storesession.StoreSessionFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.training.core.model.cms.components.SimplePDFComponentModel;
import de.hybris.training.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Controller for CMS SimplePDFComponent.
 */

@Controller("SimplePDFComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.SimplePDFComponent)
public class SimplePDFComponentController extends AbstractAcceleratorCMSComponentController<SimplePDFComponentModel>
{

// ctlr alt l + ctrl alt o
	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "storeSessionFacade")
	private StoreSessionFacade storeSessionFacade;


	@Override
	protected void fillModel(final HttpServletRequest request,
							 final Model model,
							 final SimplePDFComponentModel component)
	{


		if (customerFacade.getCurrentCustomer().getFirstName().equals("Ernests")) {
			model.addAttribute("name", "Ernests");
		}

		model.addAttribute("pdf", component.getPdf());
		model.addAttribute("media", component.getMedia());
		model.addAttribute("currency", storeSessionFacade.getCurrentCurrency().getIsocode());
		model.addAttribute("title", customerFacade.getCurrentCustomer().getTitle());


	}


}
