<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:choose>
	<c:when test="${user.firstName == 'Ernests'}">
	
		<div class="banner__component simple-banner"> 
		
		<p> Welcome, <c:out value="${user.firstName}"/> </p>
		
		
		 <img title="${fn:escapeXml(media.altText)}" alt="${fn:escapeXml(media.altText)}" 
		src="${fn:escapeXml(media.url)}"> 
				
				    <a href="${pdf.url}" class = "btn btn-info"> 
	
					Welcome Ernests
					
					</a> 
				
		</div>
	</c:when>

	<c:otherwise>
		<div class="banner__component simple-banner"> 
		   <img title="${fn:escapeXml(media.altText)}" alt="${fn:escapeXml(media.altText)}" 
			   src="${fn:escapeXml(media.url)}"> 
				
			<a href="${pdf.url}" class = "btn btn-info"> 
			
			TEST CLICK 
			
			</a> 
				
		</div> 

	</c:otherwise>
</c:choose>