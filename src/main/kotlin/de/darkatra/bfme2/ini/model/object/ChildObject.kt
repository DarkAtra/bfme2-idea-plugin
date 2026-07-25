package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor

open class ChildObject(
    override val header: SageBlockHeader = SageBlockHeader(),
    override val section1: ObjectSection1 = ObjectSection1(),
    override val section2: ObjectSection2 = ObjectSection2(),
    override val section3: ObjectSection3 = ObjectSection3(),
) : Object() {

    companion object : SageIniBlockDescriptor<ChildObject>(
        name = "ChildObject",
        parent = Object,
        headerArity = 2,
    )
}
