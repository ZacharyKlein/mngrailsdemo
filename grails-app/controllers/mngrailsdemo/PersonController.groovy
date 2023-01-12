package mngrailsdemo

import grails.validation.ValidationException
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class PersonController {

    @Autowired
    PersonService personService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        int offset = params.int('offset', 0) / 10
        def people = personService.findAllOrderByLastName(Pageable.from(offset, Math.min(max ?: 10, 100))).content
        respond people, model:[personCount: personService.count()]
    }

    def show(Long id) {
        respond personService.findById(id).orElse(null)
    }

    def create() {
        respond new Person()
    }

    def save(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect action: 'show', id: person.id
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond personService.findById(id).orElse(null)
    }

    def update(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.update(person)
        } catch (ValidationException e) {
            respond person.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect action: 'show', id: person.id
            }
            '*'{ respond person, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personService.deleteById(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
