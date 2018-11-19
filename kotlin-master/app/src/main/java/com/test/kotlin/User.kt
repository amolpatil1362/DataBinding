package com.test.kotlin

/**
 * Created by amolpatil on 03/02/18.
 */
public class User{
    var name :String
    var id :Int

    constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }

    fun  getUserName(): String {

        return name
    }

    fun setname(newName:String?){
        this.name = newName!!;
    }


    fun getUserId(): Int {
        return id;
    }


}
