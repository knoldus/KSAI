package ksai.data.parser

import breeze.linalg.{DenseMatrix, DenseVector}

case class AttributeMeta(name: String = "", typ: String = "")


case class ARFF[A](
                             relation: String = "",
                             attributes: List[AttributeMeta] = Nil,
                             labels: List[A] = Nil,
                             isDataPresent: Boolean = false,
                             data: List[Array[Double]] = Nil,
                             target: List[A] = Nil){

  private def labelMap: Map[A, Int] = {
    labels.zipWithIndex.map{case (l, index) => l -> index}.toMap
  }

  def getNumericTargets: List[Int] = {
    target.map(tgt => labelMap(tgt))
  }

}

case class Delimited[A](
                             relation: String = "",
                             attributes: List[AttributeMeta] = Nil,
                             labels: List[A] = Nil,
                             isDataPresent: Boolean = false,
                             data: List[Array[Double]] = Nil,
                             target: List[A] = Nil){

  private def labelMap: Map[A, Int] = {
    labels.zipWithIndex.map{case (l, index) => l -> index}.toMap
  }

  def getNumericTargets: List[Int] = {
    target.map(tgt => labelMap(tgt))
  }

}