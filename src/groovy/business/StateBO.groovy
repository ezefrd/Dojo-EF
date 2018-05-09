package business

import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@Builder
class StateBO implements Serializable {

    private static final long serialVersionUID = 5845431491195126126L


    String id
    String name


    Map asMap() {
        return [id: id, name: name]
    }
}