#!groovy

println "hello world"

print 'Enter Jenkins Username: '
def username = System.in.newReader().readLine()

println ''

print 'Enter Jenkins Password: '
def password = System.in.newReader().readLine()

println 'Username: ' + username
println 'Password: ' + password

