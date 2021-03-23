package lab2

import org.scalatest._
import chiseltest._ 
import chisel3._ 

class ex3Test extends FreeSpec with ChiselScalatestTester {
    "Exercise 3 Test" in {
        test(new exercise3){ c =>
            c.io.in.poke("b1000".U)
            c.io.out.expect(3.U)
        }
    }
}