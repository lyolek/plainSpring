package org.sav.plainspring.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

@Slf4j
public class SnakeCasePhysicalNamingStrategy implements PhysicalNamingStrategy {

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		log.info("toPhysicalCatalogName name: {}", name);
		return apply(name);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		log.info("toPhysicalSchemaName name: {}", name);
		return apply(name);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		log.info("toPhysicalTableName name: {}", name);
		return apply(name);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		log.info("toPhysicalSequenceName name: {}", name);
		return apply(name);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		log.info("toPhysicalColumnName name: {}", name);
		return apply(name);
	}

	private Identifier apply(Identifier name) {
		if (name == null) return null;

		String newName = name.getText()
				.replaceAll("([a-z])([A-Z])", "$1_$2")
				.toLowerCase();

		return Identifier.toIdentifier(newName);
	}
}
