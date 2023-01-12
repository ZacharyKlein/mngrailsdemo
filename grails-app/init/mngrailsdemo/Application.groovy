package mngrailsdemo

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import groovy.transform.CompileStatic

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Expression

@CompileStatic
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)

        Expression
    }
}
