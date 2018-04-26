# Fireogm
Firestore driver for hibernate-ogm

# Mission

To support Cloud Firestore in Hibernate-ogm

In order to facilitate the development of truly scalable applications for startups, I initially set out to create a JPA-like implementation which would only support [Firebase's Firestore](https://firebase.google.com/products/firestore/), but having to swap JPA implementations in testing and development vs production is a real nightmare and can lead to too many unforeseen problems.

# Project

Having explored some alternatives, Hibernate-ogm looked like the closest to what I wanted and would allow me to easily setup a small embedded db for development that was hidden beneath the same APIs that prod would use. It's still not ideal given Google cloud's poor testing tools when working outside their ecosystem.

# Contributing

Please fork this and send in PRs, file issues, get involved!
