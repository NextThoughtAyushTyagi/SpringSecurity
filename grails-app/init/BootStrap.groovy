import com.demo.Role
import com.demo.User
import com.demo.UserRole

class BootStrap {

    def init = { servletContext ->
        Role roleAdmin = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true, flush: true)
        Role roleOwner = Role.findByAuthority("ROLE_OWNER") ?: new Role(authority: "ROLE_OWNER").save(failOnError: true, flush: true)
        Role roleAgent = Role.findByAuthority("ROLE_AGENT") ?: new Role(authority: "ROLE_AGENT").save(failOnError: true, flush: true)
        Role roleCustomer = Role.findByAuthority("ROLE_CUSTOMER") ?: new Role(authority: "ROLE_CUSTOMER").save(failOnError: true, flush: true)

        User admin = User.findByUsername("admin@gmail.com") ?: new User(username: 'admin@gmail.com', password: '12345').save(flush: true)
        if (!admin?.authorities?.contains(roleAdmin)) {
            UserRole.create(admin, roleAdmin, true)
        }

        User owner = User.findByUsername("owner@gmail.com") ?: new User(username: 'admin@gmail.com', password: '12345').save(flush: true)
        if (!owner?.authorities?.contains(roleOwner)) {
            UserRole.create(owner, roleOwner, true)
        }

        User agent = User.findByUsername("agent@gmail.com") ?: new User(username: 'admin@gmail.com', password: '12345').save(flush: true)
        if (!agent?.authorities?.contains(roleAgent)) {
            UserRole.create(agent, roleAgent, true)
        }

        User customer = User.findByUsername("customer@gmail.com") ?: new User(username: 'admin@gmail.com', password: '12345').save(flush: true)
        if (!customer?.authorities?.contains(roleCustomer)) {
            UserRole.create(customer, roleCustomer, true)
        }
    }
    def destroy = {
    }
}
