package com.bookmarket.common.annotation

import org.springframework.stereotype.Component


@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class LoadAdapter(
    val value: String = ""
)
