#!groovy
 
import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule
import jenkins.model.JenkinsLocationConfiguration
import net.sf.json.JSONObject

println("=== Configuring users ===")

def instance = Jenkins.getInstance()
JenkinsLocationConfiguration location = instance.getExtensionList('jenkins.model.JenkinsLocationConfiguration')[0]
String admin_email = 'joshua.r.spickler@gmail.com'



print 'Enter Jenkins Username: '
def username = System.in.newReader().readLine()

print 'Enter Jenkins Password: '
def password = System.in.newReader().readLine()

 
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("josh420", "joshadmin420")
instance.setSecurityRealm(hudsonRealm)
 
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
 
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)
println "Updating Jenkins Email to: ${admin_email}"
location.adminAddress = admin_email
instance.save()
location.save()
