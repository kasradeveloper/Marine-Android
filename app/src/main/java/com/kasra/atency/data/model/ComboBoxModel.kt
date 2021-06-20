package com.kasra.atency.data.model

import com.kasra.atency.data.model.request.RequestClass
import com.kasra.atency.data.model.workplace.WorkplaceModel


data class ComboBoxModel (
    var value: String? = null,
    var name: String,
    var isCheck:Boolean = false,
    private var requestClass: RequestClass? = null,
    private var workplaceModel: WorkplaceModel? = null

)