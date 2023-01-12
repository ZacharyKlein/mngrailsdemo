package mngrailsdemo

import org.springframework.beans.factory.annotation.Autowired

class BootStrap {

    @Autowired
    PersonService personService

    def init = { servletContext ->
        populatePeople()
    }

    private void populatePeople() {
        personService.save new Person(firstName: 'Bill', lastName: 'Bruford')
        personService.save new Person(firstName: 'Neil', lastName: 'Peart')
        personService.save new Person(firstName: 'Danny', lastName: 'Carey')
        personService.save new Person(firstName: 'Keith', lastName: 'Moon')
        personService.save new Person(firstName: 'Phil', lastName: 'Collins')
        personService.save new Person(firstName: 'Zack', lastName: 'Brown')
        personService.save new Person(firstName: 'John', lastName: 'Bonham')
        personService.save new Person(firstName: 'Gavin', lastName: 'Harrison')
        personService.save new Person(firstName: 'Cozy', lastName: 'Powell')
        personService.save new Person(firstName: 'Ian', lastName: 'Paice')
        personService.save new Person(firstName: 'Ginger', lastName: 'Baker')
        personService.save new Person(firstName: 'Alex', lastName: 'Van Halen')
        personService.save new Person(firstName: 'Carmine', lastName: 'Appice')
        personService.save new Person(firstName: 'Carl', lastName: 'Palmer')
        personService.save new Person(firstName: 'Buddy', lastName: 'Rich')
    }
    def destroy = {
    }
}
