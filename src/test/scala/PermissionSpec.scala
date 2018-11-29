import org.scalatest._

class PermissionSpec extends FunSpec {

  it("A lawyer has access to their own case") {
    val lawyer = new Lawyer
    val aCase = new Case(lawyer)
    assert(lawyer.hasAccessTo(aCase))
  }

  it("A lawyer has not access to another lawyer's case") {
    val lawyer = new Lawyer
    val anotherLawyer = new Lawyer
    val aCase = new Case(anotherLawyer)
    assert(!lawyer.hasAccessTo(aCase))
  }

  describe("A lawyer is granted access to all another lawyer's cases") {
    val lawyer = new Lawyer
    val anotherLawyer = new Lawyer
    val aCase = new Case(anotherLawyer)
    anotherLawyer.grantTotalAccessTo(lawyer)

    it("The lawyer has access to all the other lawyer's cases") {
      assert(lawyer.hasAccessTo(aCase))
    }

    describe("But he is denied access to one particular case") {

    }
  }

  describe("A lawyer is granted total access to one of the other lawyer cases") {
    val lawyer = new Lawyer
    val anotherLawyer = new Lawyer
    val accessibleCase = new Case(anotherLawyer)
    val notAccessibleCase = new Case(anotherLawyer)
    anotherLawyer.grantTotalAccessTo(lawyer, accessibleCase)

    it("The lawyer has access to that case") {
      assert(lawyer.hasAccessTo(accessibleCase))
    }

    it("The lawyer has no access to other cases of the other lawyer") {
      assert(!lawyer.hasAccessTo(notAccessibleCase))
    }
  }

}