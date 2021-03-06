package fluentgenerator.core;

import java.util.function.Supplier;

/**
 * Basic interface for Generators.
 * <p>
 * Invoking its {@link #build()} method should always return new class instance.
 * <p>
 * Assuming model class:
 * <p>
 * <pre><code>
 *     class Person {
 *         String lastName;
 *         int age;
 *
 *         public setLastName(String v) { ... }
 *         public setAge(int v) { ... }
 *
 *         ...
 *     }
 * }
 * </code></pre>
 * <p>
 * Following generator could be defined:
 * <pre><code>
 *     interface PersonGenerator extends Generator<Person>{
 *         PersonGenerator lastName(Supplier<String> v);
 *         PersonGenerator age(Supplier<Integer> v);
 *         Person build();
 *     }
 * </code></pre>
 *
 * @author pkorus
 * @see GeneratorFactory
 */
public interface Generator<T> extends Supplier<T> {

	T build();

	default <E> E build(Class<E> target) {
		throw new UnsupportedOperationException();
	}

	@Override
	default T get() {
		return this.build();
	}
}
