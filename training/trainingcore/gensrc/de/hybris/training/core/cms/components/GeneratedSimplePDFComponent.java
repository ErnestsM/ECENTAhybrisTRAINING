/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Dec 19, 2019, 5:02:32 PM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.core.cms.components;

import de.hybris.platform.acceleratorcms.jalo.components.SimpleBannerComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.training.core.cms.components.SimplePDFComponent SimplePDFComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSimplePDFComponent extends SimpleBannerComponent
{
	/** Qualifier of the <code>SimplePDFComponent.pdf</code> attribute **/
	public static final String PDF = "pdf";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleBannerComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PDF, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimplePDFComponent.pdf</code> attribute.
	 * @return the pdf - PDF media for banner
	 */
	public Media getPdf(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, PDF);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SimplePDFComponent.pdf</code> attribute.
	 * @return the pdf - PDF media for banner
	 */
	public Media getPdf()
	{
		return getPdf( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimplePDFComponent.pdf</code> attribute. 
	 * @param value the pdf - PDF media for banner
	 */
	public void setPdf(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, PDF,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SimplePDFComponent.pdf</code> attribute. 
	 * @param value the pdf - PDF media for banner
	 */
	public void setPdf(final Media value)
	{
		setPdf( getSession().getSessionContext(), value );
	}
	
}
