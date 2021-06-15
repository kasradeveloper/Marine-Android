package com.base.base_app.data.model

import com.base.base_app.data.model.request.RequestClass
import com.base.base_app.data.model.workplace.WorkplaceModel


data class ComboBoxModel (
    var value: String? = null,
    var name: String,
    var isCheck:Boolean = false,
    private var requestClass: RequestClass? = null,
    private var workplaceModel: WorkplaceModel? = null

)