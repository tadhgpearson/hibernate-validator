// $Id$
/*
* JBoss, Home of Professional Open Source
* Copyright 2008, Red Hat Middleware LLC, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package javax.validation.constraints;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * The annotated element must be a number whose value must be lower or
 * equal than the specificed maximum.
 * <p/>
 * Supported types are:
 * <ul>
 * <li><code>BigDecimal</code></li>
 * <li><code>BigInteger</code></li>
 * <li><code>Number</code></li>
 * <li><code>String</code></li>
 * <li><code>short</code>, <code>int</code>, <code>long</code>, <code>float</code>, <code>double</code></li>
 * </ul>
 * <p/>
 * <code>null</code> elements are considered valid
 *
 * @author Emmanuel Bernard
 * @todo support byte ?!
 * @todo Is string supported or not?
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface Max {
	String message() default "{validator.max}";

	String[] groups() default { };

	/**
	 * @return Value the element must be lower or equal to
	 */
	long value();
}