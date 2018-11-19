package com.test.kotlin.network

public class NetworkRequest{
 private var url:String?=null
  private var param:HashMap<String,Any>?=null



  fun setUrl(url: String) {
    this.url = url
  }

  fun getUrl():String?{
    return url
  }


  fun setParams(parameterMap:HashMap<String,Any>){
    parameterMap.put("strFormat", "json")
    this.param = parameterMap
  }

  fun getParams():HashMap<String,Any>?{
    return param
  }
}