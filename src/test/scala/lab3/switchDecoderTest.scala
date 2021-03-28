package lab3

import org.scalatest._
import chiseltest._
import chisel3._

class switchDecoderTest extends FreeSpec with ChiselScalatestTester {
    "Decoder 2 to 4 Test" in {
        test(new Decoder2to4){ c =>
            c.io.in.poke(3.U)
            c.io.out.expect(8.U)
        }
    }
}