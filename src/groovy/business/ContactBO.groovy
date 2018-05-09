package business

import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@Builder
class ContactBO  implements Serializable, Cloneable{

    private static final long serialVersionUID = 6201392691422709549L

    String name
    String phoneNumber

    public boolean isComplete() {
        return this.name && this.phoneNumber
    }

    ContactBO clone(){
        return builder().name(this.name).phoneNumber(this.phoneNumber).build()
    }
}
