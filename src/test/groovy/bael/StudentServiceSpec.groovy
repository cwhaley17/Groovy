package bael

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class StudentServiceSpec extends Specification implements ServiceUnitTest<StudentService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    void "Test the index action returns the correct model"(){
        given:
        controller.StudentService = Mock(StudentService){
            list() >> [new Student(firstName: 'John', lastName: 'Doe')]
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        model.studentList.size() == 1
        model.studentList[0].firstName == 'John'
        model.studentList[0].lastName == 'Doe'
    }

    void "Test the delete action with an instance"(){
        given:
        controller.StudentService = Mock(StudentService){
            1 * delete(2)
        }

        when:"The domain instance is pased to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method='DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectUrl == '/studen/index'

    }
}
