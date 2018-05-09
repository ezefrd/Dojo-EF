import business.ContactBO

/**
 * Created by efridman on 7/5/18.
 */
class AbstractStoredAddressDataGenerator {

    private final String TYPE_CONTACT = 'contact'

    protected Map buildContactInfoBlock(ContactBO contactBO) {
        Map contactInfoMap = null
        if (contactBO && contactBO.isComplete()) {
            contactInfoMap = [
                    title      : contactBO.name,
                    description: contactBO.phoneNumber,
                    name       : contactBO.name,
                    phone      : contactBO.phoneNumber,
                    type       : this.TYPE_CONTACT
            ]
        }
        return contactInfoMap
    }
}
