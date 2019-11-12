package bael

class BootStrap {

    def init = { servletContext ->
        def nissan = new Make(name: 'Nissan').save()
        def ford = new Make(name: 'Ford').save()
        def chevy = new Make(name: 'Chevrolet').save()

        def titan = new Model(name: 'Titan', make: nissan).save()
        def leaf = new Model(name: 'Lead', make: nissan).save()
        def windstar = new Model(name: 'Windstar',make: ford ).save()
        def silverado = new Model(name: '2500', make:chevy).save()

        new Vehicle(name: 'Pickup', make: nissan, model:titan, year:2012).save()
        new Vehicle(name:'Economy', make: nissan, model: leaf, year: 2014).save()
        new Vehicle(name:'Minivan', make: ford, Model: windstar, year: 1990).save()
        new Vehicle(name:'Pickup', make: chevy, Model: silverado, year: 2015).save()

    }
    def destroy = {
    }
}
