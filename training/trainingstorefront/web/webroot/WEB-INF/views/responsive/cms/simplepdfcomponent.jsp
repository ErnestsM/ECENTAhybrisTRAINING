<%@ page trimDirectiveWhitespaces="true"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
 
<div class="banner__component simple-banner"> 

	<h2> Welcome, ${title} ${name}! </h2>
	<h3> Your current currency is ${currency}. </h3>

   <img title="${fn:escapeXml(media.altText)}" alt="${fn:escapeXml(media.altText)}" 
       src="${fn:escapeXml(media.url)}"> 
	    
    <a href="${pdf.url}" class = "btn btn-info"> 
	
	CONTROLLER WORKS
	
	</a> 
	
	
		
</div> 