/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.test.internal.constraintvalidators.bv.money;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import javax.money.MonetaryAmount;
import javax.validation.ConstraintValidator;
import javax.validation.constraints.Positive;

import org.hibernate.validator.internal.constraintvalidators.bv.money.PositiveValidatorForMonetaryAmount;
import org.hibernate.validator.internal.util.annotation.AnnotationDescriptor;
import org.javamoney.moneta.Money;
import org.testng.annotations.Test;

/**
 * @author Marko Bekhta
 * @author Guillaume Smet
 */
public class PositiveValidatorForMonetaryAmountTest {

	private final ConstraintValidator<Positive, MonetaryAmount> constraintValidator = new PositiveValidatorForMonetaryAmount();

	@Test
	public void nullIsValid() {
		constraintValidator.initialize( positive( true ) );

		assertTrue( constraintValidator.isValid( null, null ) );
	}

	@Test
	public void invalidIfNegative() {
		constraintValidator.initialize( positive( false ) );

		assertFalse( constraintValidator.isValid( Money.of( -1, "EUR" ), null ) );
	}

	@Test
	public void validIfPositive() {
		constraintValidator.initialize( positive( false ) );

		assertTrue( constraintValidator.isValid( Money.of( 1, "EUR" ), null ) );
	}

	@Test
	public void invalidIfZero() {
		constraintValidator.initialize( positive( true ) );

		assertFalse( constraintValidator.isValid( Money.of( 0, "EUR" ), null ) );
	}

	private Positive positive(final boolean strict) {
		AnnotationDescriptor.Builder<Positive> descriptorBuilder = new AnnotationDescriptor.Builder<>( Positive.class );
		return descriptorBuilder.build().getAnnotation();
	}
}
