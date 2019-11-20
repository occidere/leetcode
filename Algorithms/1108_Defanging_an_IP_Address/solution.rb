# @param {String} address
# @return {String}
def defang_i_paddr(address)
  address.gsub('.', '[.]')
end