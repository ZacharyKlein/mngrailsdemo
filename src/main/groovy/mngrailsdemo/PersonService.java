package mngrailsdemo;


import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository(dialect = Dialect.H2)
interface PersonService extends PageableRepository<Person, Long> {
    @NonNull
    Page<Person> findAllOrderByLastName(@NonNull Pageable pageable);
}
