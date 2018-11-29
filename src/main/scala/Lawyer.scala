import scala.collection.mutable.ArrayBuffer

class Lawyer {
  var permissions: ArrayBuffer[Permission] = new ArrayBuffer[Permission]()

  def hasAccessTo(aCase: Case): Boolean = {
    aCase.owner.equals(this) || permissions.exists(permission => permission.allowsAccessTo(aCase))
  }

  def grantTotalAccessTo(lawyer: Lawyer) = {
    lawyer.addTotalPermissionFor(this)
  }

  def grantTotalAccessTo(lawyer: Lawyer, aCase: Case) = {
    lawyer.addPermissionFor(aCase)
  }

  def addTotalPermissionFor(lawyer: Lawyer) = {
    this.permissions += new GlobalPermission(lawyer)
  }

  def addPermissionFor(aCase: Case) = {
    this.permissions += new ParticularPermission(aCase)
  }
}
