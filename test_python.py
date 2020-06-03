import unittest

class TestC(unittest.TestCase):

    def summ(self, A, B):
        return A * B

    def test_method_trig(self):
        assert self.summ(5,5) == 25, "NO"
        #self.assertEqual(self.summ(5,5) , 10, "should be 10")

    def test_bad(self):
        data = "OK"
        with self.assertRaises(TypeError):
            res = self.summ(data, "SO")

if __name__ == "__main__":
    unittest.main()

 
