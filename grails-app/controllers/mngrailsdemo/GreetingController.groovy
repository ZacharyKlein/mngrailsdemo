package mngrailsdemo


import org.springframework.beans.factory.annotation.Autowired

class GreetingController {

    @Autowired
    GreetingHelper greetingHelper

    @Autowired
    MessageSender messageSender

    def index(String name) {
        messageSender.send "Creating Greeting For [$name]"
        render greetingHelper.createGreeting(name ?: 'Unknown')
    }
}
