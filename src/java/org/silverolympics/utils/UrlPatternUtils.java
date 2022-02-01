
package org.silverolympics.utils;


import java.util.Collection;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Handles the different entered url 
 * @author Manon
 * @see org.silverolympics.filter.UrlFilter
 */
public class UrlPatternUtils {
    /*
    * verifies whether an entered url corresponds to a created servlet
    */
   private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {

      Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

      for (String servletName : map.keySet()) {
         ServletRegistration sr = map.get(servletName);

         Collection<String> mappings = sr.getMappings();
         if (mappings.contains(urlPattern)) {
            return true;
         }

      }
      return false;
   }

   /*
   * Handles servlet path such as:
   * ==> /somepath
   * ==> /somepath/*
   * ==> *.extension
   * ==> /
   */
   public static String getUrlPattern(HttpServletRequest request) {
      ServletContext servletContext = request.getServletContext();
      String servletPath = request.getServletPath();
      String pathInfo = request.getPathInfo();

      String urlPattern = null;
      if (pathInfo != null) {
         urlPattern = servletPath + "/*";
         return urlPattern;
      }
      urlPattern = servletPath;
      //checks whether the entered url corresponds to a servlet
      boolean has = hasUrlPattern(servletContext, urlPattern);
      if (has) {
         return urlPattern;
      }
      int i = servletPath.lastIndexOf('.');
      if (i != -1) {
         String ext = servletPath.substring(i + 1);
         urlPattern = "*." + ext;
         has = hasUrlPattern(servletContext, urlPattern);

         if (has) {
            return urlPattern;
         }
      }
      return "/";
   }
}